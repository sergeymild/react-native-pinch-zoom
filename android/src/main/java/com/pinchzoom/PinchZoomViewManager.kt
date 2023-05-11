package com.pinchzoom

import android.view.View
import com.ablanco.zoomy.DoubleTapListener
import com.ablanco.zoomy.TapListener
import com.ablanco.zoomy.Zoomy
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.WritableMap
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.events.RCTEventEmitter


class PinchZoomViewManager : ViewGroupManager<PinchZoomView>(), DoubleTapListener, TapListener {
  override fun getName() = "PinchZoomView"

  override fun createViewInstance(reactContext: ThemedReactContext): PinchZoomView {
    return PinchZoomView(reactContext)
  }

  override fun addView(parent: PinchZoomView, child: View, index: Int) {
    super.addView(parent, child, index)
    val activity = (parent.context as ThemedReactContext).currentActivity
    val builder = Zoomy.Builder(activity)
      .doubleTapListener(this)
      .tapListener(this)
      .target(child)
    builder.register()
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> {
    return MapBuilder.builder<String, Any>()
      .put("onDoubleTap", MapBuilder.of("registrationName", "onDoubleTap"))
      .put("onTap", MapBuilder.of("registrationName", "onTap"))
      .build()
  }

  override fun onDoubleTap(v: View) {
    val zoomView = v.parent as PinchZoomView
    val id = zoomView.id
    (v.context as ThemedReactContext).sendEventToJs(id, "onDoubleTap")
  }


  override fun onTap(v: View) {
    val zoomView = v.parent as PinchZoomView
    val id = zoomView.id
    (v.context as ThemedReactContext).sendEventToJs(id, "onTap")
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
