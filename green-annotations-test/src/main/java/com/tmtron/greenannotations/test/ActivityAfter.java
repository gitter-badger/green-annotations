/*
 * Copyright © 2016 Martin Trummer (martin.trummer@tmtron.com)
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

package com.tmtron.greenannotations.test;

import android.app.Activity;
import android.widget.Toast;
import com.tmtron.greenannotations.EventBusGreenRobot;
import org.androidannotations.annotations.EActivity;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * test class to show how to use EventBus with GreenAnnotations
 */
@EActivity
public class ActivityAfter extends Activity {

    @EventBusGreenRobot
    EventBus eventBus;

    void fireEvent(String message) {
        eventBus.post(new MessageEvent(message));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(getApplicationContext(), event.message, Toast.LENGTH_SHORT).show();
    }

}
