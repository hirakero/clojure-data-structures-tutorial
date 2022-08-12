(ns clojure-data-structures-tutorial.core)
"
ドメインに問うべき質問は以下の通りです。

  物事を順序立てて管理する必要があるのか？
  物事を追加した順序を覚えておきたいか？
  再整理で維持される順序が必要か？ (アルファベット順のように)
  新しいアイテムはどこに移動させたいか？
"
"
 List - 追加順を保持。先頭に追加。
 Vector - 追加順を保持。末尾に追加。
 Queue - 追加順を保持。末尾に追加。
 sorted Map - キーでソートされたアイテムを保持。
 sorted Set - アイテムをキーとしてソートして保持。
 HashMap - 順番を保持しない。
 Set - 順序を保持しない。
 "

(comment
  (def todos (atom [])) ;; 末尾に追加される
  ;(def todos (atom ())) ;;先頭に追加される
  ;(def todos (atom (sorted-set))) ;;アルファベット順に並べたい場合

  (defn add-todo! [item]
    (swap! todos conj item))

  (add-todo! "buy kitten")
  (add-todo! "buy cat food")
  (add-todo! "feed kitten")

  (doseq [item @todos]
    (prn item)))

(comment
  ;;優先度順に並べたい場合
  (defn priority-order [a b]
    (compare (:priority a) (:priority b)))
  (def todos (atom (sorted-set-by priority-order)))

  (defn add-todo! [item]
    (swap! todos conj item))

  (add-todo! {:priority 1 :name "Take map"})
  (add-todo! {:priority 4 :name "clean kitchen"})
  (add-todo! {:priority 2 :name "eat lunch"})

  (doseq [item @todos]
    (prn item)))



