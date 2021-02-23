package com.mycompany.myapp;

import android.app.Activity;
import android.os.Bundle;
import com.mycompany.myapp.R;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;
import android.util.Log;
import android.widget.Switch;
import android.widget.CompoundButton;
import android.support.v4.widget.TextViewCompat;
import android.widget.TextView;
import android.nfc.Tag;
import java.util.Set;
import android.widget.EditText;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.app.ProgressDialog;
import android.widget.ToggleButton;


public class MainActivity extends Activity 
{
	private TextView bl_adress;
	private Switch bl_switch;
	private EditText edittext1;
	private TextView textview;
	private ToggleButton togglebutton;

	private Boolean bl_state;





	BluetoothAdapter b = BluetoothAdapter.getDefaultAdapter();
	
	
	
	
	
	
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		bl_state = b.isEnabled();
		this.edittext1 = (EditText)findViewById(R.id.edittext);
		this.textview = (TextView)super.findViewById(R.id.textview);
		this.togglebutton = (ToggleButton)super.findViewById(R.id.togglebutton);

		Set<BluetoothDevice> devices = b.getBondedDevices();

		textview.setText("已绑定设备数量 : " + devices.size());
		Log.d("TAG", "已绑定设备数量 : " + devices.size());
		for (BluetoothDevice bonddevice:devices)
		{

			edittext1.setText("设备名称 : " + bonddevice.getName() + "\nMac地址= " + bonddevice.getAddress());
			Log.d("TAG", "设备名称 : " + bonddevice.getName() + "   Mac地址= " + bonddevice.getAddress());
		}









		this.bl_adress = (TextView)super.findViewById(R.id.bl_adress);
		this.bl_switch = (Switch)super.findViewById(R.id.bl_switch);


		if (b.isEnabled())
		{
			bl_switch.setChecked(true);
			togglebutton.setChecked(true);

		}
		else
		{
			bl_switch.setChecked(false);
			togglebutton.setChecked(false);

		}


		bl_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
				{
					if (isChecked)
					{
						b.enable();

					}
					else
					{
						b.disable();
					}


				}
			});
			
			
		togglebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
				{
					if (isChecked)
					{
						b.enable();

					}
					else
					{
						b.disable();
					}


				}
			});







		//String s = b.getAddress();
		String bl_name = b.getName();

		bl_adress.setText("本机蓝牙名称：" + bl_name);}











	//Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);  

	//startActivityForResult(intent, 0x1);  

//直接打开蓝牙  

	//b.enable();  

//关闭蓝牙  

	//b.disable();  



	









}
