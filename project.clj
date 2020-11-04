(defproject clj-codewars "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [jpmonettas/flow-storm "0.3.1"]]
  :main ^:skip-aot clj-codewars.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[com.jakemccrary/lein-test-refresh "0.24.1"]
                             [io.aviso/pretty "0.1.37"]]
                   :dependencies [[pjstadig/humane-test-output "0.10.0"]
                                  [io.aviso/pretty "0.1.37"]]
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]}})