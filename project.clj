(defproject pluralsight "0.1.0-SNAPSHOT"
  :description "Pluralsight clojure course"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.clojure/data.json "2.4.0"]
                 [org.postgresql/postgresql "42.4.0"]]
  :repl-options {:init-ns pluralsight.core})
