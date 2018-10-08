package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Floor {

  private final Map<Character, Aisle> aisles;
  private final int nbOfAisles;

  private Floor(int nbOfAisles, Map<Character, Aisle> aisles) {
    this.aisles = aisles;
    this.nbOfAisles = nbOfAisles;
  }

  public Map<Character, Aisle> getAisles() {
    return this.aisles;
  }

  public Optional<Aisle> getAisle(Character aisleId) {
    return Optional.ofNullable(this.aisles.get(aisleId));
  }

  public int getNbOfAisles() {
    return this.nbOfAisles;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private final Map<Character, Aisle> aisles;

    private Builder(){
      this.aisles = new HashMap<>();
    }

    public Builder aisle(Character aisleId, Aisle aisle) {
      assert(!this.aisles.containsKey(aisleId));
      this.aisles.put(aisleId, aisle);
      return this;
    }

    public Floor build() {
      return new Floor(this.aisles.size(), Collections.unmodifiableMap(this.aisles));
    }

  }


}
