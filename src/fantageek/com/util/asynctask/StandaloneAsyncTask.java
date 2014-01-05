package fantageek.com.util.asynctask;

import java.lang.ref.WeakReference;

import android.os.AsyncTask;

/**
 * This kind of AsyncTask provides ways to inject processing from outside in
 * general manner. So it can be a stand alone class, not an inner class, and
 * finish general jobs. <br/>
 * It is implemented by allowing to pass in listeners for pre/post/... execute
 * listener.<br/>
 * To extend this class right, child class must explicitly call super methods like onPost/onPreExecute ...
 * 
 * @author anhkhoi
 * 
 */
public abstract class StandaloneAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
	public static interface ExecutingListener<Params, Progress, Result> {
		void onPostExecute(Result result);
		void onPreExecute();
	}
	
	protected WeakReference<ExecutingListener<Params, Progress, Result>> executingListener = null;
	
	public StandaloneAsyncTask(ExecutingListener<Params, Progress, Result> listener) {
		setExecutingListener(listener);
	}
	
	@Override
	protected void onPostExecute(Result result) {
		super.onPostExecute(result);
		
		if (isListenerAvailable())
			getExecutingListener().onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		
		if (isListenerAvailable())
			getExecutingListener().onPreExecute();
	}
	
	protected boolean isListenerAvailable() {
		return executingListener.get() != null;
	}
	
	protected ExecutingListener<Params, Progress, Result> getExecutingListener() {
		return executingListener.get();
	}

	public void setExecutingListener(ExecutingListener<Params, Progress, Result> executingListener) {
		this.executingListener = new WeakReference<StandaloneAsyncTask.ExecutingListener<Params, Progress, Result>>(executingListener);
	}
}
