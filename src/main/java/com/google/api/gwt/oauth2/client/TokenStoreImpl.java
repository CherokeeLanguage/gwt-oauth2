/*
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.gwt.oauth2.client;

/**
 * Default implementation of token storage, using localStorage to store tokens
 * (if supported).
 *
 * @author jasonhall@google.com (Jason Hall)
 */
class TokenStoreImpl implements TokenStore {
  private static final String KEY = "gwt-oauth2";

  @Override
  public native void set(String key, String value) /*-{
    var obj = JSON.parse($wnd.localStorage.getItem(
      @com.google.api.gwt.oauth2.client.TokenStoreImpl::KEY) || '{}');
    obj[key] = value;
    $wnd.localStorage.setItem(
      @com.google.api.gwt.oauth2.client.TokenStoreImpl::KEY, JSON.stringify(obj));
  }-*/;

  @Override
  public native String get(String key) /*-{
    return JSON.parse($wnd.localStorage.getItem(
      @com.google.api.gwt.oauth2.client.TokenStoreImpl::KEY) || '{}')[key] || null;
  }-*/;

  @Override
  public native void clear() /*-{
    $wnd.localStorage.removeItem(
      @com.google.api.gwt.oauth2.client.TokenStoreImpl::KEY);
  }-*/;
}
