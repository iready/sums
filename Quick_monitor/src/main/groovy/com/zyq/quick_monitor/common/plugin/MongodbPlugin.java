/**
 * Copyright (c) 2011-2013, kidzhou 周磊 (zhouleib1412@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zyq.quick_monitor.common.plugin;

import com.jfinal.plugin.IPlugin;
import com.mongodb.MongoClient;

import java.util.HashMap;
import java.util.Map;

//import com.jfinal.log.Logger;

public class MongodbPlugin implements IPlugin {

    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final int DEFAUL_PORT = 27017;

     static Map<Class<? extends MongoModel<?>>, String> collList = new HashMap<>();

//    protected final Logger logger = Logger.getLogger(getClass());

    private MongoClient client;
    private String host;
    private int port;
    private String database;

    public MongodbPlugin(String database) {
        this.host = DEFAULT_HOST;
        this.port = DEFAUL_PORT;
        this.database = database;
    }

    public MongodbPlugin(String host, int port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    @Override
    public boolean start() {
        client = new MongoClient(host, port);
        MongoKit.init(client, database);
        return true;
    }

    @Override
    public boolean stop() {
        if (client != null) {
            client.close();
        }
        return true;
    }

    public MongodbPlugin addMapping(String tableName, Class<? extends MongoModel<?>> modelClass) {
        collList.put(modelClass, tableName);
        return this;
    }
}
