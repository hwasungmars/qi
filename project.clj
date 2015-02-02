(defproject qi "0.1.0-SNAPSHOT"
  :description "Quite Interesting questions."
  :source-paths ["src/main/clojure"]
  :java-source-paths ["src/main/java" "src/test/java"]
  :test-paths ["src/test/clojure"]
  :junit ["src/test/java"]

  :resource-paths ["src/main/resource"]
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :plugins [[lein-junit "1.1.8"]]
  :profiles {:dev {:dependencies [[junit/junit "4.11"]]}})
