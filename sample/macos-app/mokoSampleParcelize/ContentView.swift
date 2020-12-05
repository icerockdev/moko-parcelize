//
//  ContentView.swift
//  mokoSampleParcelize
//
//  Created by Aleksey Mikhailov on 05.12.2020.
//

import SwiftUI
import MultiPlatformLibrary

let user = User(
  firstName: "Aleksey",
  lastName: "Mikhailov",
  phone: "+79000000000",
  age: 26
)

struct ContentView: View {
    var body: some View {
      Text("Hello, \(user.firstName)!")
            .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
