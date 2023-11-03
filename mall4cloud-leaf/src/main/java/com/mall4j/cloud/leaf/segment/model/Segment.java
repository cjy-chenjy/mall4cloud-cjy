package com.mall4j.cloud.leaf.segment.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author left
 */
public class Segment {

	private AtomicLong value = new AtomicLong(0); //对 long 类型的变量进行原子操作，这里就是产生的id值

	private volatile long max; //当前号段起始id

	private volatile int step;  //每次缓存数量

	private volatile int randomStep; //随机增长

	private final SegmentBuffer buffer; //双buffer

	public Segment(SegmentBuffer buffer) {
		this.buffer = buffer;
	}

	public AtomicLong getValue() {
		return value;
	}

	public void setValue(AtomicLong value) {
		this.value = value;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public SegmentBuffer getBuffer() {
		return buffer;
	}

	public long getIdle() {
		return this.getMax() - getValue().get();
	}

	@Override
	public String toString() {
		return "Segment(" + "value:" +
				value +
				",max:" +
				max +
				",step:" +
				step +
				")";
	}

	public int getRandomStep() {
		return randomStep;
	}

	public void setRandomStep(int randomStep) {
		this.randomStep = randomStep;
	}

}
