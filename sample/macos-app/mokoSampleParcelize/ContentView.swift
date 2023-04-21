//
//  ContentView.swift
//  mokoSampleParcelize
//
//  Created by Aleksey Mikhailov on 05.12.2020.
//

import SwiftUI
import MultiPlatformLibrary

struct ContentView: View {
    var body: some View {
      Text("Hello, \(TestUsers.shared.user.firstName)!")
            .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
