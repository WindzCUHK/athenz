/**
 * Copyright 2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.athenz.zms.store.jdbc;

import com.yahoo.athenz.common.server.db.PoolableDataSource;
import com.yahoo.athenz.zms.ResourceException;
import com.yahoo.athenz.zms.store.ObjectStore;
import com.yahoo.athenz.zms.store.ObjectStoreConnection;
import com.yahoo.athenz.zms.utils.ZMSUtils;

public class JDBCObjectStore implements ObjectStore {

    PoolableDataSource src;
    private int opTimeout = 60; //in seconds
    
    public JDBCObjectStore(PoolableDataSource src) {
        this.src = src;
    }
    
    @Override
    public ObjectStoreConnection getConnection(boolean autoCommit) {
        final String caller = "getConnection";
        try {
            JDBCConnection jdbcConn = new JDBCConnection(src.getConnection(), autoCommit);
            jdbcConn.setOperationTimeout(opTimeout);
            return jdbcConn;
        } catch (Exception ex) {
            throw ZMSUtils.error(ResourceException.SERVICE_UNAVAILABLE, ex.getMessage(), caller);
        }
    }
    
    @Override
    public void setOperationTimeout(int opTimeout) {
        this.opTimeout = opTimeout;
    }
    
    @Override
    public void clearConnections() {
        src.clearPoolConnections();
    }
}
