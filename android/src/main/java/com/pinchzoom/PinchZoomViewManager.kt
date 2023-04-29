package com.pinchzoom

import android.view.View
import com.ablanco.zoomy.DoubleTapListener
import com.ablanco.zoomy.Zoomy
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.WritableMap
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.events.RCTEventEmitter


class PinchZoomViewManager : ViewGroupManager<PinchZoomView>(), DoubleTapListener {
  override fun getName() = "PinchZoomView"

  override fun createViewInstance(reactContext: ThemedReactContext): PinchZoomView {
    return PinchZoomView(reactContext)
  }

  @ReactProp(name = "doubleTapEnabled")
  fun doubleTapEnabled(view: PinchZoomView, value: Boolean) {
    view.doubleTapEnabled = value
  }

  override fun addView(parent: PinchZoomView, child: View, index: Int) {
    super.addView(parent, child, index)
    val activity = (parent.context as ThemedReactContext).currentActivity
    val builder = Zoomy.Builder(activity).doubleTapListener(this).target(child)
    builder.register()
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> {
    return MapBuilder.builder<String, Any>()
      .put("onDoubleTap", MapBuilder.of("registrationName", "onDoubleTap"))
      .build()
  }

  override fun onDoubleTap(v: View) {
    val zoomView = v.parent as PinchZoomView
    if (!zoomView.doubleTapEnabled) return
    val id = zoomView.id
    (v.context as ThemedReactContext).sendEventToJs(id, "onDoubleTap")
  }


  fun ReactContext.sendEventToJs(
    viewId: Int,
    eventName: String,
    argsMaker: ((args: WritableMap) -> Unit)? = null,
  ) {
    val event = Arguments.createMap()
    argsMaker?.invoke(event)
    getJSModule(RCTEventEmitter::class.java)
      .receiveEvent(viewId, eventName, event)
  }
}
