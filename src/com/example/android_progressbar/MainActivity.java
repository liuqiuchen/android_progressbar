package com.example.android_progressbar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private ProgressBar progressBar;
	private Button add_btn;
	private Button reduce_btn;
	private Button reset_btn;
	private TextView textView;
	
	//声明progressDialog的对象
	private ProgressDialog progressDialog;
	
	private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //启用窗口特征，启用带进度和不带进度的两种进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);//带进度的进度条
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);//不带进度的进度条
                
        //加载布局文件
        setContentView(R.layout.main);
        
        //显示两种进度条
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(true);
        //带进度的进度条设置刻度
        //Max = 10000
        setProgress(600);
        
        
        //初始化
        init();
        
       /* //getProgress()获取第一进度
        //getSecondaryProgress()获取第二进度
        //getMax()获取最大进度
        int firstProgress = progressBar.getProgress();
        int secondaryProgress = progressBar.getSecondaryProgress();
        int maxProgress = progressBar.getMax();

        //textView默认显示内容：
        textView.setText("第一进度：" + (int)((firstProgress/(float)maxProgress)*100) + "% 第二进度："
        + (int)((secondaryProgress/(float)maxProgress)*100) + "%");*/
        
        showText();
        
        //设置按钮的监听器
        add_btn.setOnClickListener(this);
        reduce_btn.setOnClickListener(this);
        reset_btn.setOnClickListener(this);
        show.setOnClickListener(this);
        
    }

	private void showText() {
		// TODO Auto-generated method stub
		
		//getProgress()获取第一进度
        //getSecondaryProgress()获取第二进度
        //getMax()获取最大进度
        int firstProgress = progressBar.getProgress();
        int secondaryProgress = progressBar.getSecondaryProgress();
        int maxProgress = progressBar.getMax();

        //textView默认显示内容：
        textView.setText("第一进度：" + (int)((firstProgress/(float)maxProgress)*100) + "% 第二进度："
        + (int)((secondaryProgress/(float)maxProgress)*100) + "%");
	}

	private void init() {
		// TODO Auto-generated method stub
		progressBar = (ProgressBar) findViewById(R.id.horizontal);
		add_btn = (Button) findViewById(R.id.add);
		reduce_btn = (Button) findViewById(R.id.reduce);
		reset_btn = (Button) findViewById(R.id.reset);
		textView = (TextView) findViewById(R.id.text);
		show = (Button) findViewById(R.id.show);
		
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.add:
			//增加第一进度和第二进度10个刻度
			progressBar.incrementProgressBy(10);
			progressBar.incrementSecondaryProgressBy(10);
			showText();
			break;
		case R.id.reduce:
			//减少第一进度和第二进度10个刻度
			progressBar.incrementProgressBy(-10);
			progressBar.incrementSecondaryProgressBy(-10);
			showText();
			break;
		case R.id.reset:
			progressBar.setProgress(50);
			progressBar.setSecondaryProgress(80);
			showText();
			break;
		case R.id.show:
			//1.新建ProgressDialog对象
			progressDialog = new ProgressDialog(MainActivity.this);
			//2.设置显示风格
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			//3.设置对话框的标题
			progressDialog.setTitle("我是标题");
			//4.设置标题上的图标
			progressDialog.setIcon(R.drawable.ic_launcher);
			//5.设置对话框里的文字信息
			progressDialog.setMessage("进度条对话框");
			//6.设置进度条最大刻度
			progressDialog.setMax(100);
			//7.设置初始化的进度
			progressDialog.incrementProgressBy(50);
			//8.进度条是明显显示进度的
			progressDialog.setIndeterminate(false);
			//9.设定一个确定按钮
			progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
				}
			});
			//10.是否可以通过返回按钮退出对话框
			progressDialog.setCancelable(true);
			//11.显示ProgressDialog
			progressDialog.show();
			
			break;
		
		}
	}


    
}
