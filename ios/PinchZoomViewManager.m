#import <React/RCTViewManager.h>

@interface RCT_EXTERN_MODULE(PinchZoomViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(disableScrollViewOnPinch, BOOL)
RCT_EXPORT_VIEW_PROPERTY(doubleTapEnabled, BOOL)
RCT_EXPORT_VIEW_PROPERTY(onDoubleTap, RCTDirectEventBlock)

@end
