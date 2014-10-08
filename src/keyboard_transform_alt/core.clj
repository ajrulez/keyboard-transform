(ns keyboard-transform-alt.core
  (:gen-class))

(defn flip [m k]
    (map #(nth k %) m))

(defn xform [k k2i c]
  (let [idx (get k2i c -1)]
    (if (= idx -1)
      c
      (nth k idx))))

(defn hvn2map [c]
  (cond (= c 'V) [30 31 32 33 34 35 36 37 38 39 20 21 22 23 24 25 26 27 28
                      29 10 11 12 13 14 15 16 17 18 19 0 1 2 3 4 5 6 7 8 9]
        (= c 'H) [9 8 7 6 5 4 3 2 1 0 19 18 17 16 15 14 13 12 11 10 29 28
                     27 26 25 24 23 22 21 20 39 38 37 36 35 34 33 32 31 30]
;;
;; too 'clever' code. the above is much clearer
;;       (= c 'H) (into [] (concat (range 30 40) (range 20 30) 
;;                                 (range 10 20) (range 0 10)))
;;       (= c 'V) (into [] (concat (range 9 -1 -1) (range 19 9 -1) 
;;                                 (range 29 19 -1) (range 39 29 -1)))
        :else (into [] (map #(mod (+ % c) 40) (range 40)))))

(defn -main [& args]
  (let [keyboard "1234567890qwertyuiopasdfghjkl;zxcvbnm,./"
        key2idx (zipmap keyboard (range 40))
        xfmaps (map #(hvn2map (read-string %)) args)
        xfinal (reduce #(flip %1 %2) xfmaps)
        keymap (flip xfinal keyboard)]
    (doseq [input (line-seq (java.io.BufferedReader. *in*))]
      (println (apply str (map #(xform keymap key2idx %) input))))))
