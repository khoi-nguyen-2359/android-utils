package fantageek.com.util.android.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class DataArrayAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mData;
    protected int mResViewId;

    public DataArrayAdapter(Context context, int resViewId) {
        mData = new ArrayList<T>();
        mContext = context;
        mResViewId = resViewId;
    }

    public void remove(T t) {
        mData.remove(t);
    }

    public void remove(int position) {
        mData.remove(position);
    }

    public void add(int position, T object) {
        mData.add(position, object);
    }

    public void add(T object) {
        mData.add(object);
    }

    public void addAll(Collection<? extends T> addition) {
        for (T t : addition) {
            mData.add(t);
        }
    }

    public void addAll(int location, Collection<? extends T> addition) {
        for (T t : addition) {
            mData.add(location++, t);
        }
    }

    public void clear() {
        mData.clear();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
