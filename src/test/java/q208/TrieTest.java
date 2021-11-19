package q208;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieTest {
    @Test
    void shouldSearchAndInsertWord() {
        Trie trie = new Trie();
        assertFalse(trie.search("apple"));
        trie.insert("apple");
        assertTrue(trie.search("apple"));
    }

    @Test
    void shouldNotSearchAndInsertWord() {
        Trie trie = new Trie();
        assertFalse(trie.search("apple"));
        trie.insert("app");
        assertFalse(trie.search("apple"));
    }

    @Test
    void shouldNotSearchWordWithPrefixOnly() {
        Trie trie = new Trie();
        assertFalse(trie.search("app"));
        trie.insert("apple");
        assertFalse(trie.search("app"));
    }

    @Test
    void shouldReturnCorrectResultForStartWith() {
        Trie trie = new Trie();
        assertFalse(trie.startsWith("app"));
        trie.insert("apple");
        assertTrue(trie.startsWith("app"));
    }

    @Test
    void shouldRunSampleActions() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
        assertTrue(trie.startsWith("app"));
    }
}
