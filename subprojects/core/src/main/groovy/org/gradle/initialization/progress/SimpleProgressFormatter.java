/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.initialization.progress;

public class SimpleProgressFormatter implements ProgressFormatter {
    private final int total;
    private int current;
    private String postfix;

    public SimpleProgressFormatter(int total, String postfix) {
        this.total = total;
        this.postfix = postfix;
    }

    public String incrementAndGetProgress() {
        if (current == total) {
            throw new IllegalStateException("Cannot increment beyond the total of: " + total);
        }
        current++;
        return getProgress();
    }

    public String getProgress() {
        return current + "/" + total + " " + postfix;
    }
}