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
@SuppressWarnings("rawtypes")
public abstract class StandaloneAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
	public static interface ExecutingListener<Params, Progress, Result> {
		void onPostExecute(Result result);
		void onPreExecute();
	}
	
	protected WeakReference<ExecutingListener> executingListener = null;
	
	public StandaloneAsyncTask(ExecutingListener<Params, Progress, Result> listener) {
		setExecutingListener(listener);
	}
	
	@SuppressWarnings("unchecked")
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
	
	@Override
	protected void onCancelled() {
		super.onCancelled();
		
		executingListener = null;
	}
	
	protected boolean isListenerAvailable() {
		return executingListener.get() != null;
	}
	
	protected ExecutingListener getExecutingListener() {
		return executingListener.get();
	}

	public void setExecutingListener(ExecutingListener executingListener) {
		this.executingListener = new WeakReference<StandaloneAsyncTask.ExecutingListener>(executingListener);
	}
}
