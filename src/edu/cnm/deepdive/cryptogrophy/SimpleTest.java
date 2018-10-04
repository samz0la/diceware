package edu.cnm.deepdive.cryptogrophy;

import java.security.SecureRandom;
import java.util.Random;

public class SimpleTest {

  public static void main(String[] args) {
    Random rng = new SecureRandom();
    WordSource source = new BundleSource("wordlist");
    ArtifactGenerator generator = new PassphraseGenerator(source, rng);
    for(int i = 0; i < 10; i++) {
      System.out.println(generator.generate(6));
    }
  }
}
