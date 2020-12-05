/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import UIKit
import MultiPlatformLibrary

class TestViewController: UIViewController {
    
    @IBOutlet var label: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        let user = User(
            firstName: "Aleksey",
            lastName: "Mikhailov",
            phone: "+79000000000",
            age: 26
        )
        
        label.text = "Hello, \(user.firstName)!"
    }
}
