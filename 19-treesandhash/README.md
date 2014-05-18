A hashmap functions like a Python dictionary, with a set of keys and a set of values associated with each key.
There can be no duplicates in the set of keys but there can be duplicate values.

A hashset functions like a mathematical set, with no duplicate elements in the hashset.

A hashmap is an example of open-hashing while a hashset is an example of closed-hashing.

Comparing the Hashmap with the Treemap:
It seems that assigning in the Hashmap is more efficient than in a Treemap, as it took half a second for a hashmap to map 1000000 items,
while it took the Treemap 4.5 seconds to do the same mapping