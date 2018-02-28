package com.aaron.demo.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.aaron.demo.R;
import com.aaron.demo.model.EditModel;

import java.util.List;

/**
 * Created by JiangHua
 * on 2018/2/26
 */

public class EditTextAdapter extends BaseAdapter {

    private Context mContext;
    private List<EditModel> mListModel;

    public EditTextAdapter(Context context, List<EditModel> list) {
        mContext = context;
        mListModel = list;
    }

    @Override
    public int getCount() {
        return mListModel != null ? mListModel.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mListModel.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CustomHolder holder;
        if (view == null) {
            holder = new CustomHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_list_edit, viewGroup, false);
            holder.label = (TextView) view.findViewById(R.id.tv_label);
            holder.editText = (EditText) view.findViewById(R.id.ed_content);
            holder.editText.addTextChangedListener(new EditTextWatcher(holder));
            view.setTag(holder);
        } else {
            holder = (CustomHolder) view.getTag();
        }

        holder.position = i;

        holder.label.setText(mListModel.get(i).getLabel());
        holder.editText.setText(mListModel.get(i).getInputContent());
        return view;
    }

    class CustomHolder {
        TextView label;
        EditText editText;

        int position;
    }

    class EditTextWatcher implements TextWatcher {

        CustomHolder holder;

        private EditTextWatcher(CustomHolder holder) {
            this.holder = holder;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String inputContent = editable.toString();
            EditModel model = mListModel.get(holder.position);
            if (TextUtils.isEmpty(inputContent)) {
                //拿到集合对象
                model.setInputContent("");
            } else {
                //拿到集合对象
                model.setInputContent(inputContent);
            }
            mListModel.set(holder.position, model);
        }
    }
}
