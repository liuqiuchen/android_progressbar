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
	
	//����progressDialog�Ķ���
	private ProgressDialog progressDialog;
	
	private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //���ô������������ô����ȺͲ������ȵ����ֽ�����
        requestWindowFeature(Window.FEATURE_PROGRESS);//�����ȵĽ�����
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);//�������ȵĽ�����
                
        //���ز����ļ�
        setContentView(R.layout.main);
        
        //��ʾ���ֽ�����
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(true);
        //�����ȵĽ��������ÿ̶�
        //Max = 10000
        setProgress(600);
        
        
        //��ʼ��
        init();
        
       /* //getProgress()��ȡ��һ����
        //getSecondaryProgress()��ȡ�ڶ�����
        //getMax()��ȡ������
        int firstProgress = progressBar.getProgress();
        int secondaryProgress = progressBar.getSecondaryProgress();
        int maxProgress = progressBar.getMax();

        //textViewĬ����ʾ���ݣ�
        textView.setText("��һ���ȣ�" + (int)((firstProgress/(float)maxProgress)*100) + "% �ڶ����ȣ�"
        + (int)((secondaryProgress/(float)maxProgress)*100) + "%");*/
        
        showText();
        
        //���ð�ť�ļ�����
        add_btn.setOnClickListener(this);
        reduce_btn.setOnClickListener(this);
        reset_btn.setOnClickListener(this);
        show.setOnClickListener(this);
        
    }

	private void showText() {
		// TODO Auto-generated method stub
		
		//getProgress()��ȡ��һ����
        //getSecondaryProgress()��ȡ�ڶ�����
        //getMax()��ȡ������
        int firstProgress = progressBar.getProgress();
        int secondaryProgress = progressBar.getSecondaryProgress();
        int maxProgress = progressBar.getMax();

        //textViewĬ����ʾ���ݣ�
        textView.setText("��һ���ȣ�" + (int)((firstProgress/(float)maxProgress)*100) + "% �ڶ����ȣ�"
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
			//���ӵ�һ���Ⱥ͵ڶ�����10���̶�
			progressBar.incrementProgressBy(10);
			progressBar.incrementSecondaryProgressBy(10);
			showText();
			break;
		case R.id.reduce:
			//���ٵ�һ���Ⱥ͵ڶ�����10���̶�
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
			//1.�½�ProgressDialog����
			progressDialog = new ProgressDialog(MainActivity.this);
			//2.������ʾ���
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			//3.���öԻ���ı���
			progressDialog.setTitle("���Ǳ���");
			//4.���ñ����ϵ�ͼ��
			progressDialog.setIcon(R.drawable.ic_launcher);
			//5.���öԻ������������Ϣ
			progressDialog.setMessage("�������Ի���");
			//6.���ý��������̶�
			progressDialog.setMax(100);
			//7.���ó�ʼ���Ľ���
			progressDialog.incrementProgressBy(50);
			//8.��������������ʾ���ȵ�
			progressDialog.setIndeterminate(false);
			//9.�趨һ��ȷ����ť
			progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "ȷ��", Toast.LENGTH_SHORT).show();
				}
			});
			//10.�Ƿ����ͨ�����ذ�ť�˳��Ի���
			progressDialog.setCancelable(true);
			//11.��ʾProgressDialog
			progressDialog.show();
			
			break;
		
		}
	}


    
}
