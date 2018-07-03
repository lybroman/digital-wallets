package com.example.lybro.myapplication;
import android.view.View.OnClickListener;
import android.content.Context;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
import android.widget.ImageView;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
public class btnDisplayQRcodeClick implements OnClickListener {

    private Context context;
    private AlertDialog.Builder builder;
    private ImageView iv;

    public btnDisplayQRcodeClick(Context ct, ImageView iv){
        this.context=ct;
        this.iv = iv;
        this.builder=new AlertDialog.Builder(ct);
        this.builder.setTitle("Display QR code");
        this.builder.setMessage("Please use your mobile phone App to scan it!");
        this.builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
    }
    private Bitmap generateBitmap(String content,int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix encode = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            int[] pixels = new int[width * height];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (encode.get(j, i)) {
                        pixels[i * width + j] = 0x00000000;
                    } else {
                        pixels[i * width + j] = 0xffffffff;
                    }
                }
            }
            return Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.RGB_565);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void onClick(View v) {
        Bitmap sample = generateBitmap("www.baidu.com", 300, 300);
        //this.builder.create().show();
        this.iv.setImageBitmap(sample);
    }

}