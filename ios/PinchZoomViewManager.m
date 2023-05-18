#import <React/RCTViewManager.h>

@interface RCT_EXTERN_MODULE(PinchZoomViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(disabledPinchZoom, BOOL)
RCT_EXPORT_VIEW_PROPERTY(disableScrollViewOnPinch, BOOL)
RCT_EXPORT_VIEW_PROPERTY(onDoubleTap, RCTDirectEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onTap, RCTDirectEventBlock)

@end
