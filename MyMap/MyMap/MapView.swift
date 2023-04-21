//
//  MapView.swift
//  MyMap
//
//  Created by 早乙女　誠 on 2023/03/27.
//

import SwiftUI
import MapKit

//
enum MapType {
    case standard     //　標準
    case satellite    //　衛生写真
    case hybrid       //　衛生写真+交通機関ラベル
}

struct MapView: UIViewRepresentable {
    //　検索キーワード
    let searchKey: String
    //
    let mapType: MapType
    
    // MKMapViewのインスタンス生成
    func makeUIView(context: Context) -> MKMapView {
        //
        MKMapView()
    }// makeUIView ここまで
    
    //　表示した View が更新されるたびに実行
    func updateUIView(_ uiView: MKMapView, context: Context) {
     
        //　入力された文字をデバックエリアに表示
        print("検索キーワード:\(searchKey)")
        
        //
        switch mapType {
        case .standard:
            //
            uiView.preferredConfiguration = MKStandardMapConfiguration(elevationStyle: .flat)
            
        case .satellite:
            //
            uiView.preferredConfiguration = MKImageryMapConfiguration()
            
        case .hybrid:
            //
            uiView.preferredConfiguration = MKHybridMapConfiguration()
        }
        
        // CLGeocoderインスタンスを生成
        let geocoder = CLGeocoder()
        
        // 入力された文字から位置情報を取得
        geocoder.geocodeAddressString(
            searchKey,
            completionHandler: { (placemarks, error) in
                //　リクエストの結果が存在し、1件目の情報から位置情報を取り出す
                if let placemarks,
                   let firstPlacemark = placemarks.first,
                   let location = firstPlacemark.location {
                    
                    // 位置情報から緯度経度をtargetCoordinateに取り出す
                    let targetCoordinate = location.coordinate
                    
                    //　緯度経度をデバックエリアに表示
                    print("経度緯度 : \(targetCoordinate)")
                    
                    //
                    let pin = MKPointAnnotation()
                    
                    //
                    pin.coordinate = targetCoordinate
                    
                    //
                    pin.title = searchKey
                    
                    //
                    uiView.addAnnotation(pin)
                    
                    //
                    uiView.region = MKCoordinateRegion(
                        center: targetCoordinate,
                        latitudinalMeters: 500.0,
                        longitudinalMeters: 500.0)
                    
                }//　ifここまで
            })// geocoderここまで
            
        
    }//　updateUIView　ここまで
    
}// MapView ここまで

struct MapView_Previews: PreviewProvider {
    static var previews: some View {
        MapView(searchKey: "羽田空港", mapType: .standard)
    }
}
