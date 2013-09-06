(defproject colourizer "0.1.0-SNAPSHOT"
  :dependencies [
                 [org.clojure/clojure "1.5.1"]
                 [clansi "1.0.0"]]
  :main colourizer.core
  :profiles {:uberjar {:aot :all}})
