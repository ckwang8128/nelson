//: ----------------------------------------------------------------------------
//: Copyright (C) 2017 Verizon.  All Rights Reserved.
//:
//:   Licensed under the Apache License, Version 2.0 (the "License");
//:   you may not use this file except in compliance with the License.
//:   You may obtain a copy of the License at
//:
//:       http://www.apache.org/licenses/LICENSE-2.0
//:
//:   Unless required by applicable law or agreed to in writing, software
//:   distributed under the License is distributed on an "AS IS" BASIS,
//:   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//:   See the License for the specific language governing permissions and
//:   limitations under the License.
//:
//: ----------------------------------------------------------------------------
package nelson
package yaml

import org.scalacheck._, Prop._, Arbitrary.arbitrary

object PortParserSpec extends Properties("PortParser.parse"){
  import Fixtures._

  val validPortNumber = Gen.choose(1, 65535)
  val protocol = Gen.oneOf("tcp", "http", "https")

  property("using expected format") =
    forAll(alphaStr, validPortNumber, protocol){ (s: String, i: Int, p: String) =>
      PortParser.parse(s"$s->$i/$p").isRight
    }
}