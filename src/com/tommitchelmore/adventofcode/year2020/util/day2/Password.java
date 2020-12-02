package com.tommitchelmore.adventofcode.year2020.util.day2;

public class Password {
  private PasswordPolicy policy;
  private String content;

  public Password(PasswordPolicy policy, String content) {
    this.policy = policy;
    this.content = content;
  }

  public PasswordPolicy getPolicy() {
    return policy;
  }

  public String getContent() {
    return content;
  }
}
