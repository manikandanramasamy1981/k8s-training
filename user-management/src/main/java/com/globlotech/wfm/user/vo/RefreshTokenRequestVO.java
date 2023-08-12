package com.globlotech.wfm.user.vo;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequestVO {
  @NotBlank
  private String refreshToken;

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}
