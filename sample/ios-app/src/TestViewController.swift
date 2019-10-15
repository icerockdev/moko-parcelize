/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import UIKit
import MultiPlatformLibrary

class TestViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()

        let _ = User(firstName: "Aleksey",
                     lastName: "Mikhailov",
                     phone: "+79000000000",
                     age: 26)
    }
}
