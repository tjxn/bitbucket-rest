/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cdancy.bitbucket.rest.domain.pullrequest;

import com.cdancy.bitbucket.rest.error.Error;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import java.util.List;

@AutoValue
public abstract class PagedCommitResponse {

    public abstract int size();

    public abstract int limit();

    public abstract boolean isLastPage();

    public abstract List<Commit> values();

    public abstract int start();

    public abstract int authorCount();

    public abstract int totalCount();

    @Nullable
    public abstract String filter();

    public abstract int nextPageStart();

    public abstract List<Error> errors();

    public PagedCommitResponse() {
    }

    @SerializedNames({ "size", "limit", "isLastPage", "values", "start", "authorCount", "totalCount", "filter", "nextPageStart", "errors" })
    public static PagedCommitResponse create(int size, int limit, boolean isLastPage, List<Commit> values,
                                             int start, int authorCount, int totalCount, String filter,
                                             int nextPageStart, List<Error> errors) {
        return new AutoValue_PagedCommitResponse(size, limit, isLastPage,
                values != null ? ImmutableList.copyOf(values) : ImmutableList.<Commit>of(),
                start,
                authorCount,
                totalCount,
                filter,
                nextPageStart,
                errors != null ? ImmutableList.copyOf(errors) : ImmutableList.<Error> of());
    }
}