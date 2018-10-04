package edu.cnm.deepdive.cryptogrophy;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BundleSource implements WordSource {

  private ArrayList<String> words;

  public BundleSource(String basename) {
    ResourceBundle bundle = ResourceBundle.getBundle(basename);
    words = new ArrayList<>(
        bundle.keySet().stream()
            .map((k) -> bundle.getString(k))
            .collect(Collectors.toList())
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
