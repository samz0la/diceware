package edu.cnm.deepdive.cryptogrophy;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BundleSource implements WordSource {

  private ArrayList<String> words;

  public BundleSource(String basename) {
    ResourceBundle bundle = ResourceBundle.getBundle(basename);
    words = new ArrayList<>(
        bundle.keySet().stream() // create stream of keys(string)
            .map((k) -> bundle.getString(k)) //map lets us transform types, returns &stream of strings
            .filter((s) -> !s.matches("^.*\\W|\\d.*$")) //Filter out words with punctuation or digits
            .filter((s) -> s.length() > 3)
            .collect(Collectors.toList()) //collect lets us collect the items into a different kind of structure, returns a list of strings, which we use as the argument to our array list constructor
    );
  }

  @Override
  public String get(int i) {
    return words.get(i);
  }

  @Override
  public int size() {
    return words.size();
  }
}
