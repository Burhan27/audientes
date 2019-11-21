package dk.sens.android.ble.tasks;

/*
 * Copyright (c) 2016 SENS Innovation ApS <morten@sens.dk>
 * All rights reserved.
 *
 * - Redistribution and use in source and binary forms, with or without
 *   modification, are permitted only with explicit permission from the copyright
 *   owner.
 * - Any redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

import android.util.Log;

import java.util.UUID;

import dk.sens.android.ble.ExtendedBLEPeripheral;
import dk.sens.android.ble.generic.GenericBLEDevice;
import dk.sens.android.util.ByteUtils;

public class WriteCharTask extends BLETask
{
    static final String TAG = "S-BLE WriteCharTask";
    protected byte[] mData = null;
    protected UUID mServiceUUID = null;
    protected UUID mCharUUID = null;

    public WriteCharTask(UUID serviceUUID, UUID charUUID, byte[] data)
    {
        mServiceUUID = serviceUUID;
        mCharUUID = charUUID;
        mData = data;
    }

    @Override
    public void execute(ExtendedBLEPeripheral peripheral)
    {
        super.execute(peripheral);
        boolean status = peripheral.getDevice().writeChar(mServiceUUID, mCharUUID, mData);
        Log.i(TAG, "Write " + status + " " + ByteUtils.toHexString(mData));
    }

    @Override
    public void onCharacteristicWrite(GenericBLEDevice device, UUID char_uuid, boolean status)
    {
        Log.i(TAG, "Write Completed");
        onCompleted(status);
    }

}