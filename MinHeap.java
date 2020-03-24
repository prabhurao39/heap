package com.geeks.must;

/*
 * Using Library Functions We use PriorityQueue class to implement Heaps in Java. 
 * By default Min Heap is implemented by this class.
 * 
 * for kth element, 2k + 1 is left child & 2k + 2 is right child;
 */
public class MinHeap {

  int[] heap = new int[10];
  int ptrSize = 0;

  public void add(int value) {
    if (ptrSize < heap.length) {
      heap[ptrSize] = value;
      int curr = ptrSize;
      while (heap[curr] < heap[getParentIndex(curr)]) {
        swap(curr, getParentIndex(curr));
        curr = getParentIndex(curr);
      }
      ptrSize++;
    }
    printHeap();
  }

  private void printHeap() {
    for (int i = 0; i <= ptrSize; i++)
      System.out.print("  " + heap[i]);
    System.out.println();
  }

  public void heapifyUp() {
    for (int i = ptrSize; i > 0; i--) {
      minHeapifyUp(i);
    }
  }

  public void minHeapifyUp(int k) {
    if ((2*k+2) > ptrSize) return;
    int LC = getLC(k);
    int RC = getRC(k);
    if (LC < RC) {
      swap(k, getLCIndex(k));
      minHeapifyUp(getLCIndex(k));
    } else {
      swap(k, getRCIndex(k));
      minHeapifyUp(getRCIndex(k));
    }
  }

  public int remove() {
    int temp = heap[0];
    heap[0] = heap[--ptrSize];
    minHeapifyUp(0);
    printHeap();
    return temp;
  }

  public void swap(int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  public static void main(String[] args) {
    MinHeap cache = new MinHeap();
    cache.add(5);
    cache.add(1);
    cache.add(4);
    cache.add(2);
    cache.add(3);
    cache.add(0);
    cache.add(18);
    System.out.println(" rem: " + cache.remove());
    System.out.println(" rem: " + cache.remove());
    System.out.println(" rem: " + cache.remove());
    System.out.println(" rem: " + cache.remove());
    System.out.println(" rem: " + cache.remove());
    System.out.println(" rem: " + cache.remove());
    
    System.out.println(" rem: " + cache.remove());
  }

  public int getParent(int i) {
    return heap[(i - 1) / 2];
  }

  public int getParentIndex(int i) {
    return ((i - 1) / 2);
  }

  public int getLC(int k) {
    return heap[2 * k + 1];
  }

  public int getRC(int k) {
    return heap[2 * k + 2];
  }
  
  private int getLCIndex(int i) {
    return 2 * i + 1;
  }

  private int getRCIndex(int i) {
    return 2 * i + 2;
  }
}