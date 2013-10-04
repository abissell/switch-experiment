switch-experiment
=================

Java source code for micro benchmark tests yielding strange results when switching on int

See discussion on related StackOverflow performance question:
http://stackoverflow.com/questions/15621083/why-does-java-switch-on-ordinal-ints-appear-to-run-faster-with-added-cases

Oracle engineers have lowered the minimum generated jump table size in HotSpot as a result of the SO discussion:
http://hg.openjdk.java.net/jdk8/jdk8/hotspot/rev/34bd5e86aadb

Copyright 2013 Andrew Bissell

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
