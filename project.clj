(defproject keyboard-transform "0.1.0-SNAPSHOT"
  :description "Keyboard transform interview question"
  :url "https://github.com/ambakshi/keyboard-transform"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot keyboard-transform.core
  ;; :main ^:skip-aot keyboard-transform-alt.core ;; original implementation
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
