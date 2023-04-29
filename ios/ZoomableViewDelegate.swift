//
//  ZoomableViewDelegate.swift
//  ZoomableView
//
//  Created by kevin.ngh54 on 01/01/2023.
//

import UIKit

public protocol ZoomableViewDelegate: AnyObject {
    func zoomableViewDidZoom(_ view: ZoomableView)
    func zoomableViewEndZoom(_ view: ZoomableView)
}
