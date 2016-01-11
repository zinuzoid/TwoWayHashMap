package com.zinuzoid.twowayhashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * TwoWayHashMap
 * on 1/11/2016 AD
 *
 * @author Jetsada Machom <jim@imjim.im>
 */
public class TwoWayHashMap<K, V> implements Map<K, V> {

	private Map<K, V> mNormalMap;
	private Map<V, K> mReverseMap;

	public TwoWayHashMap() {
		mNormalMap = new HashMap<>();
		mReverseMap = new HashMap<>();
	}

	@Override
	public void clear() {
		mNormalMap.clear();
		mReverseMap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return mNormalMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return mReverseMap.containsKey(value);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return mNormalMap.entrySet();
	}

	@Override
	public V get(Object key) {
		return mNormalMap.get(key);
	}

	@Override
	public boolean isEmpty() {
		return mNormalMap.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return mNormalMap.keySet();
	}

	@Override
	public V put(K key, V value) {
		V put = mNormalMap.put(key, value);
		mReverseMap.put(value, key);
		return put;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		mNormalMap.putAll(map);
		for(Entry<? extends K, ? extends V> e : map.entrySet()) {
			mReverseMap.put(e.getValue(), e.getKey());
		}
	}

	@Override
	public V remove(Object key) {
		V value = mNormalMap.remove(key);
		mReverseMap.remove(value);
		return value;
	}

	@Override
	public int size() {
		return mNormalMap.size();
	}

	@Override
	public Collection<V> values() {
		return mNormalMap.values();
	}

	// =============================================================================================

	public K getByValue(V value) {
		return mReverseMap.get(value);
	}

	public K putByValue(V value, K key) {
		mNormalMap.put(key, value);
		K put = mReverseMap.put(value, key);
		return put;
	}

	public K removeByValue(V value) {
		K key = mReverseMap.remove(value);
		mNormalMap.remove(key);
		return key;
	}

}
