//
//  ContentView.swift
//  MyMap
//
//  Created by 早乙女　誠 on 2023/03/27.
//

import SwiftUI

struct ContentView: View {
    
    //
    @State var inputText: String = ""
    //
    @State var displaySearchKey: String = ""
    //
    @State var displayMapType: MapType = .standard
    
    var body: some View {
        // 垂直にレイアウト
        VStack {
            //
            TextField("キーワード", text: $inputText, prompt: Text("キーワードを入力してください"))
            //
                .onSubmit {
                    //
                    displaySearchKey = inputText
                }
            //
                .padding()
            
            //
            ZStack(alignment: .bottomTrailing) {
                //　マップを表示
                MapView(searchKey: displaySearchKey, mapType: displayMapType)
                
                //
                Button {
                    //
                    if displayMapType == .standard {
                        displayMapType = .satellite
                    } else if displayMapType == .satellite {
                        displayMapType = .hybrid
                    } else {
                        displayMapType = .standard
                    }
                } label: {
                    //
                    Image(systemName: "map")
                        .resizable()
                        .frame(width: 35.0, height: 35.0)
                } //
                //
                .padding(.trailing, 20.0)
                //
                .padding(.bottom, 30.0)
                
            } //ZStack ここまで
            
        }//VStack ここまで
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
