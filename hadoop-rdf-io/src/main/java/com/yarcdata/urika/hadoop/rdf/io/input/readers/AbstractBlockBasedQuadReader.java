/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.yarcdata.urika.hadoop.rdf.io.input.readers;

import org.apache.jena.riot.lang.PipedRDFIterator;

import com.hp.hpl.jena.sparql.core.Quad;
import com.yarcdata.urika.hadoop.rdf.io.input.util.TrackableInputStream;
import com.yarcdata.urika.hadoop.rdf.io.input.util.TrackedPipedQuadsStream;
import com.yarcdata.urika.hadoop.rdf.io.input.util.TrackedPipedRDFStream;
import com.yarcdata.urika.hadoop.rdf.types.QuadWritable;

/**
 * An abstract record reader for whole file triple formats
 * 
 * @author rvesse
 * 
 */
public abstract class AbstractBlockBasedQuadReader extends AbstractBlockBasedNodeTupleReader<Quad, QuadWritable> {

    @Override
    protected PipedRDFIterator<Quad> getPipedIterator() {
        return new PipedRDFIterator<Quad>();
    }

    @Override
    protected TrackedPipedRDFStream<Quad> getPipedStream(PipedRDFIterator<Quad> iterator, TrackableInputStream input) {
        return new TrackedPipedQuadsStream(iterator, input);
    }

    @Override
    protected QuadWritable createInstance(Quad tuple) {
        return new QuadWritable(tuple);
    }
}
