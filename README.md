# keyboard-transform

When I interviewed in early 2013, I was given the following programming test. You were given a laptop with a clean login (nothing installed, except standard OSX software) and you had access to the internet.  You were to write a program that maintained the state of a 10x4 subset of the keyboard.  From left to right:

    1 -> 0 (10 keys)
    Q -> P (10 keys)
    A -> ; (10 keys)
    Z -> / (10 keys)

Given these keys, you could apply various transforms:

    H - horizontal mirror (about Y-axis)
    V - vertical mirror (about X-axis)
    N - Keys shifted by right (+N) or left (-N)

You are given a string representing a transform, then you are asked what a string would look like on the transformed keyboard.

    For a horizontal (H) flip 1 becomes 0, 2 becomes 9, ... , q becomes p, w becomes o
    For a vertical (V) flip 1 becomes z, q becomes a, ..., 0 becomes /, p becomes ;
    A +-ive shift, 1 becomes 2, 2 becomes 3, ... / becomes 1 (wrap around)
    A -ive shift, 1 becomes /, 2 becomes 1, ...

You're given some strings and transform to apply. For example:

    Transform "Hello" by H V -1  and you get "Hjqqa".
    Transform "Hello" by H V V H and you get "Hello" (identity transform)

You're given 2h to come up with a solution in the language of your choice. You can consult the internet, but not friends, etc.  I wrote my solution in Python then Clojure. When I came home I rewrote the Clojure version into something that I found to be 'nicer'. To try the original implementation uncomment the `;; main ...` and comment out the `:main ..` line from `project.clj`

    :main ^:skip-aot keyboard-transform.core
    ;; :main ^:skip-aot keyboard-transform-alt.core ;; original implementation

## Installation

Download from https://github.com/ambakshi/keyboard-transform.

    $ lein uberjar

On OSX you can install lein via brew:

    $ brew install leiningen

## Usage

    $ java -jar keyboard-transform-0.1.0-SNAPSHOT-standalone.jar [args]

## Options

The program reads from stdin and the keyboard transform is passed via arguments.

## Examples

    $ echo "Hello" | lein run H V -1
    Hjqqa

    $ echo Hello | java -jar target/uberjar/keyboard-transform-0.1.0-SNAPSHOT-standalone.jar H V -1
    Hjqqa

## License

Copyright © 2014 Amit Bakshi, San Francisco, CA.

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
