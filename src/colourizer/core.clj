(ns colourizer.core
  (:gen-class)
  (:use [clansi]))

(defn- highlight [text]
  (style text :bg-red))

(defn -main [text]
  (doseq [line (line-seq (java.io.BufferedReader. *in*))] 
    (println (clojure.string/replace line text (highlight text)))))
