(defproject adventura "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ubergraph "0.8.2"]
                 [jline/jline "2.14.6"]
                 ]
  :java-cmd "/usr/java/latest/bin/java"
  :repl-options {:init-ns adventura.core})
