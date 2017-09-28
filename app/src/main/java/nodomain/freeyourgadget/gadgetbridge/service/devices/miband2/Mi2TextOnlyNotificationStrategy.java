package nodomain.freeyourgadget.gadgetbridge.service.devices.miband2;

import android.bluetooth.BluetoothGattCharacteristic;

import nodomain.freeyourgadget.gadgetbridge.devices.miband.VibrationProfile;
import nodomain.freeyourgadget.gadgetbridge.service.btle.BtLEAction;
import nodomain.freeyourgadget.gadgetbridge.service.btle.GattCharacteristic;
import nodomain.freeyourgadget.gadgetbridge.service.btle.TransactionBuilder;
import nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.alertnotification.AlertCategory;
import nodomain.freeyourgadget.gadgetbridge.service.devices.common.SimpleNotification;

/**
 * Created by russa: support text-only messages
 */

public class Mi2TextOnlyNotificationStrategy extends Mi2TextNotificationStrategy {

    private final BluetoothGattCharacteristic newAlertCharacteristic;

    public Mi2TextOnlyNotificationStrategy(MiBand2Support support) {
        super(support);
        newAlertCharacteristic = support.getCharacteristic(GattCharacteristic.UUID_CHARACTERISTIC_NEW_ALERT);
    }

    @Override
    protected void sendCustomNotification(VibrationProfile vibrationProfile, SimpleNotification simpleNotification, BtLEAction extraAction, TransactionBuilder builder) {
        if(AlertCategory.CustomTextOnly.equals(simpleNotification.getAlertCategory())) {
            this.sendAlert(simpleNotification, builder);
            return;
        }
        super.sendCustomNotification(vibrationProfile, simpleNotification, extraAction, builder);
    }
}
