package com.ugchain.wallet.utils.wallet.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class: com.ugchain.wallet.utils.wallet <br>
 * Description: TODO <br>
 *
 * @author xwc1125 <br>
 * @version V1.0
 * @Copyright: Copyright (c) 2017 <br>
 * @date 2017/6/2  16:48 <br>
 */
public class ByteStreams {
    public static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copy((InputStream)in, (OutputStream)out);
        return out.toByteArray();
    }
    public static long copy(InputStream from, OutputStream to) throws IOException {
        checkNotNull(from);
        checkNotNull(to);
        byte[] buf = new byte[8192];
        long total = 0L;

        while(true) {
            int r = from.read(buf);
            if(r == -1) {
                return total;
            }

            to.write(buf, 0, r);
            total += (long)r;
        }
    }

    public static <T> T checkNotNull(T reference) {
        if(reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }
}
