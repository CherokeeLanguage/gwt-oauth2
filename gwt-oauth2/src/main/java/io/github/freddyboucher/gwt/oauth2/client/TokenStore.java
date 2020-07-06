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

package io.github.freddyboucher.gwt.oauth2.client;

import java.util.Set;

/**
 * Interface for storing, retrieving, and clearing stored tokens.
 *
 * @author jasonhall@google.com (Jason Hall)
 */
public interface TokenStore {

  String STORAGE_PREFIX = "gwt-oauth2-";

  void set(String key, String value);

  String get(String key);

  void remove(String key);

  Set<String> keySet();

  default void clear() {
    keySet().forEach(this::remove);
  }
}
