/*
 * Copyright (C) 2016 The Android Open Source Project
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
 * limitations under the License
 */

package com.android.systemui.statusbar.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.view.View;

/**
 * Wraps a notification containing a big picture template
 */
public class NotificationBigPictureTemplateViewWrapper extends NotificationTemplateViewWrapper {

    protected NotificationBigPictureTemplateViewWrapper(Context ctx, View view) {
        super(ctx, view);
    }

    @Override
    public void notifyContentUpdated(StatusBarNotification notification) {
        super.notifyContentUpdated(notification);
        updateImageTag(notification);
    }

    private void updateImageTag(StatusBarNotification notification) {
        final Bundle extras = notification.getNotification().extras;
        Icon overRiddenIcon = extras.getParcelable(Notification.EXTRA_LARGE_ICON_BIG);
        if (overRiddenIcon != null) {
            mPicture.setTag(ImageTransformState.ICON_TAG, overRiddenIcon);
        }
    }
}
